package org;

import org.enums.Estado;
import org.enums.Prioridad;
import org.hilos.AlarmaRecordatorio;
import org.model.*;
import org.strategy.EmailNotificacion;
import org.strategy.NotificacionesStrategy;
import org.strategy.NumeroNotificacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioActual;

    public static void main(String[] args) {

        // CORREGIDO: Se limpió el fragmento intercalado erróneo
        Usuario usuarioDefault = new UsuarioPremium("1001", "jane doe", "janed@gmail.com", "000");
        usuarios.add(usuarioDefault);

        boolean salir = false;

        System.out.println("=== GESTOR DE TAREAS ===");

        while (!salir) {

            mostrarMenu();
            int opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    crearWorkspace();
                    break;
                case 4:
                    incluirPersonaWorkspace();
                    break;
                case 5:
                    eliminarWorkspace();
                    break;
                case 6:
                    crearTarea();
                    break;
                case 7:
                    crearRecordatorio();
                    break;
                case 8:
                    editarEvento();
                    break;
                case 9:
                    eliminarEvento();
                    break;
                case 10:
                    mostrarWorkspace();
                    break;
                case 11:
                    listarUsuarios();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

        System.out.println("Sistema finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("Usuario actual: " + obtenerNombreUsuarioActual());
        System.out.println("1. Registrar usuario");
        System.out.println("2. Iniciar sesion");
        System.out.println("3. Crear workspace");
        System.out.println("4. Incluir persona en workspace");
        System.out.println("5. Eliminar workspace");
        System.out.println("6. Crear tarea en workspace");
        System.out.println("7. Crear recordatorio en workspace");
        System.out.println("8. Editar evento de workspace");
        System.out.println("9. Eliminar evento de workspace");
        System.out.println("10. Mostrar workspace");
        System.out.println("11. Listar usuarios");
        System.out.println("0. Salir");
    }

    private static void registrarUsuario() {
        System.out.println("\n=== REGISTRAR USUARIO ===");

        String id = leerTexto("ID: ");
        String nombre = leerTexto("Nombre: ");
        String email = leerTexto("Email: ");
        String password = leerTexto("Password: ");
        String tipo = leerTexto("Tipo (clasico/premium): ");

        Usuario usuario;

        if (tipo.equalsIgnoreCase("premium")) {
            usuario = new UsuarioPremium(id, nombre, email, password);
        } else {
            usuario = new UsuarioClasico(id, nombre, email, password, false);
        }

        usuarios.add(usuario);
        usuarioActual = usuario;

        System.out.println("Usuario registrado: " + usuario.getNombre_usuario());
    }

    private static void iniciarSesion() {
        System.out.println("\n=== INICIAR SESION ===");

        String email = leerTexto("Email: ");
        String password = leerTexto("Password: ");

        for (Usuario usuario : usuarios) {
            if (usuario.autenticar(email, password)) {
                usuarioActual = usuario;
                System.out.println("Sesion iniciada: " + usuario.getNombre_usuario());
                return;
            }
        }

        System.out.println("Credenciales incorrectas.");
    }

    private static void crearWorkspace() {
        if (!haySesionActiva()) {
            return;
        }

        System.out.println("\n=== CREAR WORKSPACE ===");

        String id = leerTexto("ID del workspace: ");
        String nombre = leerTexto("Nombre: ");
        String descripcion = leerTexto("Descripcion: ");

        usuarioActual.crearWorkspace(id, nombre, descripcion);
    }

    private static void incluirPersonaWorkspace() {
        if (!haySesionActiva()) {
            return;
        }

        System.out.println("\n=== INCLUIR PERSONA EN WORKSPACE ===");

        GestorWorkspace workspace = seleccionarWorkspace(usuarioActual.getWorkspaces());

        if (workspace == null) {
            return;
        }

        Usuario usuarioInvitado = seleccionarUsuario();

        if (usuarioInvitado == null) {
            return;
        }

        usuarioActual.incluirPersonasWorkspace(usuarioInvitado, workspace);
    }

    private static void eliminarWorkspace() {
        if (!haySesionActiva()) {
            return;
        }

        System.out.println("\n=== ELIMINAR WORKSPACE ===");

        GestorWorkspace workspace = seleccionarWorkspace(usuarioActual.getWorkspaces());

        if (workspace != null) {
            usuarioActual.eliminarWorkspace(workspace);
        }
    }

    private static void crearTarea() {
        if (!haySesionActiva()) {
            return;
        }

        System.out.println("\n=== CREAR TAREA ===");

        GestorWorkspace workspace = seleccionarWorkspace(usuarioActual.getWorkspaces());

        if (workspace == null) {
            return;
        }

        String id = leerTexto("ID del evento: ");
        String nombre = leerTexto("Nombre: ");
        String descripcion = leerTexto("Descripcion: ");
        LocalDate fecha = leerFecha("Fecha (YYYY-MM-DD): ");
        Prioridad prioridad = leerPrioridad();
        Estado estado = leerEstado();

        Tarea tarea = new Tarea(
                id,
                nombre,
                descripcion,
                usuarioActual,
                fecha,
                prioridad,
                estado
        );

        workspace.agregarEvento(tarea);
    }

    private static void crearRecordatorio() {
        if (!haySesionActiva()) {
            return;
        }

        System.out.println("\n=== CREAR RECORDATORIO ===");

        GestorWorkspace workspace = seleccionarWorkspace(usuarioActual.getWorkspaces());

        if (workspace == null) {
            return;
        }

        String id = leerTexto("ID del evento: ");
        String nombre = leerTexto("Nombre: ");
        String descripcion = leerTexto("Descripcion: ");
        LocalDateTime hora = leerFechaHora("Fecha y hora (YYYY-MM-DDTHH:MM): ");

        Recordatorio recordatorio = new Recordatorio(
                id,
                nombre,
                descripcion,
                usuarioActual,
                hora.toLocalDate(),
                hora
        );

        recordatorio.setEstrategia(seleccionarEstrategiaNotificacion());
        workspace.agregarEvento(recordatorio);
        iniciarHiloAlarma(recordatorio);
    }

    private static void editarEvento() {
        if (!haySesionActiva()) {
            return;
        }

        System.out.println("\n=== EDITAR EVENTO ===");

        GestorWorkspace workspace = seleccionarWorkspace(usuarioActual.getWorkspaces());

        if (workspace == null) {
            return;
        }

        Evento evento = seleccionarEvento(workspace);

        if (evento == null) {
            return;
        }

        String nuevoNombre = leerTexto("Nuevo nombre: ");
        String nuevaDescripcion = leerTexto("Nueva descripcion: ");

        workspace.editarEventos(evento, nuevoNombre, nuevaDescripcion);
    }

    private static void eliminarEvento() {
        if (!haySesionActiva()) {
            return;
        }

        System.out.println("\n=== ELIMINAR EVENTO ===");

        GestorWorkspace workspace = seleccionarWorkspace(usuarioActual.getWorkspaces());

        if (workspace == null) {
            return;
        }

        Evento evento = seleccionarEvento(workspace);

        if (evento != null) {
            workspace.eliminarEventos(evento);
        }
    }

    private static void mostrarWorkspace() {
        if (!haySesionActiva()) {
            return;
        }

        System.out.println("\n=== MOSTRAR WORKSPACE ===");

        GestorWorkspace workspace = seleccionarWorkspace(usuarioActual.getWorkspaces());

        if (workspace == null) {
            return;
        }

        workspace.mostrarInfoGrupo();
        mostrarEventos(workspace);
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        System.out.println("\n=== USUARIOS ===");

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            System.out.println((i + 1) + ". " + usuario.getNombre_usuario()
                    + " - " + usuario.getEmail());
        }
    }

    private static void iniciarHiloAlarma(Recordatorio recordatorio) {
        AlarmaRecordatorio alarmaRecordatorio = new AlarmaRecordatorio(recordatorio);
        Thread hiloAlarma = new Thread(alarmaRecordatorio);
        hiloAlarma.start();

        System.out.println("Alarma programada en segundo plano.");
    }

    // Mapeo explícito para el número telefónico / SMS usando NumeroNotificacion
    private static NotificacionesStrategy seleccionarEstrategiaNotificacion() {
        System.out.println("\nEstrategia de notificacion:");
        System.out.println("1. Telefono (SMS)");
        System.out.println("2. Email");

        int opcion = leerEntero("Seleccione estrategia: ");

        if (opcion == 2) {
            return new EmailNotificacion();
        }

        // Si elige 1 (o cualquier otra opción por defecto), se usará la estrategia de Teléfono
        return new NumeroNotificacion();
    }

    private static GestorWorkspace seleccionarWorkspace(List<GestorWorkspace> workspaces) {
        if (workspaces.isEmpty()) {
            System.out.println("No hay workspaces disponibles.");
            return null;
        }

        System.out.println("\nWorkspaces disponibles:");

        for (int i = 0; i < workspaces.size(); i++) {
            GestorWorkspace workspace = workspaces.get(i);
            System.out.println((i + 1) + ". " + workspace.getNombre_gestor());
        }

        int opcion = leerEntero("Seleccione workspace: ");

        if (opcion < 1 || opcion > workspaces.size()) {
            System.out.println("Workspace no valido.");
            return null;
        }

        return workspaces.get(opcion - 1);
    }

    private static Usuario seleccionarUsuario() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return null;
        }

        listarUsuarios();

        int opcion = leerEntero("Seleccione usuario: ");

        if (opcion < 1 || opcion > usuarios.size()) {
            System.out.println("Usuario no valido.");
            return null;
        }

        return usuarios.get(opcion - 1);
    }

    private static Evento seleccionarEvento(GestorWorkspace workspace) {
        if (workspace.getEventos().isEmpty()) {
            System.out.println("No hay eventos en este Workspace.");
            return null;
        }

        mostrarEventos(workspace);

        int opcion = leerEntero("Seleccione evento: ");

        if (opcion < 1 || opcion > workspace.getEventos().size()) {
            System.out.println("Evento no valido.");
            return null;
        }

        return workspace.getEventos().get(opcion - 1);
    }

    private static void mostrarEventos(GestorWorkspace workspace) {
        System.out.println("\n--- Eventos del workspace ---");

        if (workspace.getEventos().isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        for (int i = 0; i < workspace.getEventos().size(); i++) {
            Evento evento = workspace.getEventos().get(i);
            System.out.println((i + 1) + ". " + evento.getNombre()
                    + " - " + evento.getClass().getSimpleName());
        }
    }

    private static boolean haySesionActiva() {
        if (usuarioActual == null) {
            System.out.println("Primero registre un usuario o inicie sesion.");
            return false;
        }

        return true;
    }

    private static String obtenerNombreUsuarioActual() {
        if (usuarioActual == null) {
            return "Ninguno";
        }

        return usuarioActual.getNombre_usuario();
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido.");
            }
        }
    }

    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            try {
                return LocalDate.parse(leerTexto(mensaje));
            } catch (RuntimeException e) {
                System.out.println("Formato invalido. Use YYYY-MM-DD.");
            }
        }
    }

    private static LocalDateTime leerFechaHora(String mensaje) {
        while (true) {
            try {
                return LocalDateTime.parse(leerTexto(mensaje));
            } catch (RuntimeException e) {
                System.out.println("Formato invalido. Use YYYY-MM-DDTHH:MM.");
            }
        }
    }

    private static Prioridad leerPrioridad() {
        while (true) {
            try {
                return Prioridad.valueOf(
                        leerTexto("Prioridad (ALTA/MEDIA/BAJA): ").toUpperCase()
                );
            } catch (IllegalArgumentException e) {
                System.out.println("Prioridad invalida.");
            }
        }
    }

    private static Estado leerEstado() {
        while (true) {
            try {
                return Estado.valueOf(
                        leerTexto("Estado (PENDIENTE/EN_PROGRESO/COMPLETADO/CANCELADA): ")
                                .toUpperCase()
                );
            } catch (IllegalArgumentException e) {
                System.out.println("Estado invalido.");
            }
        }
    }
}