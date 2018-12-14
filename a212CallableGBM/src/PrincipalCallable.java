
public class PrincipalCallable {
    public static void main(String[] args) {
        ProcyFunc.crearProcedimientos();
        ConsultaCallable.subirNota(args);
        ConsultaCallable.mostrarAsignatura(args);
    }
}
