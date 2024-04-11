public class Database {
    // Campo estático para almacenar la instancia singleton
    private static Database instance; 

    // Constructor privado para evitar la creación directa de instancias de la clase
    private Database() {
        
    }
 
    public static synchronized Database getInstance() { // Implementación de método estático público para obtener la instancia singleton
        if (instance == null) {
            instance = new Database(); // Implementación de inicialización diferida dentro del método estático
        }
        return instance;
    }

    // Método para simular una operación de consulta en la base de datos
    public void query(String sql) {
        System.out.println("Ejecutando consulta: " + sql);
       
    }
}

public class Application {
    public static void main(String[] args) {
        // Obtener la instancia singleton de la base de datos
        Database foo = Database.getInstance(); 

        foo.query("SELECT ...");

        
        Database bar = Database.getInstance(); // Obtener la misma instancia en otra parte del código
        bar.query("SELECT ...");

        // Verificamos si son la misma instancia
        System.out.println("foo y bar son la misma instancia: " + (foo == bar));
    }
}
