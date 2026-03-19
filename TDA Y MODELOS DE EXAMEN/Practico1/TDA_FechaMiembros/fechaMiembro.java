package TDA_FechaMiembros;
public class fechaMiembro {
    public static class Fecha {
         int dia,mes,año;

    // Constructor
    public Fecha(int dia, int mes, int año) {
        this.año = Math.max(año, 1); //definiendo maximo 
        this.mes = Math.min(Math.max(mes, 1), 12); 
        this.dia = Math.min(Math.max(dia, 1), diasEnMes(this.mes, this.año));
    }

    // Métodos para devolver la fecha en diferentes formatos
    public String obtenerFechaString() {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }

    public String obtenerFechaFormatoExtendido() {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                          "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return String.format("%02d de %s de %04d", dia, meses[mes - 1], año);
    }

    // Métodos para modificar la fecha
    public void cambiarDia(int nuevoDia) {
        dia = Math.min(Math.max(nuevoDia, 1), diasEnMes(mes, año));
    }

    public void cambiarMes(int nuevoMes) {
        mes = Math.min(Math.max(nuevoMes, 1), 12);
        dia = Math.min(dia, diasEnMes(mes, año)); // Asegurar que el día es válido en el nuevo mes
    }

    public void cambiarAño(int nuevoAño) {
        año = Math.max(nuevoAño, 1);
        dia = Math.min(dia, diasEnMes(mes, año)); // Asegurar que el día es válido en el nuevo año
    }

    // Métodos para obtener los valores de la fecha
    public int recuperarDia() { return dia; }
    public int recuperarMes() { return mes; }
    public int recuperarAnio() { return año; }

    // Método para reiniciar la fecha
    public void reiniciar(int nuevoDia, int nuevoMes, int nuevoAño) {
        año = Math.max(nuevoAño, 1);
        mes = Math.min(Math.max(nuevoMes, 1), 12);
        dia = Math.min(Math.max(nuevoDia, 1), diasEnMes(mes, año));
    }

    // Método para adelantar la fecha
    public void adelantar(int d, int m, int a) {
        año += a;
        mes += m;
        dia += d;
        normalizar();
    }

    // Método de utilidad para asegurarse de que los valores están en el rango correcto
    private void normalizar() {
        while (mes > 12) {
            mes -= 12;
            año++;
        }

        while (dia > diasEnMes(mes, año)) {
            dia -= diasEnMes(mes, año);
            mes++;
            if (mes > 12) {
                mes = 1;
                año++;
            }
        }
    }

    // Método que devuelve el número de días en un mes determinado
    private int diasEnMes(int mes, int año) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes == 2 && esBisiesto(año)) {
            return 29;
        }
        return diasPorMes[mes - 1];
    }

    // Método para determinar si un año es bisiesto
    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    // Método para imprimir la fecha
    public void imprimir() {
        System.out.println(obtenerFechaString());
    }

    public static void main(String[] args) {
        Fecha fecha = new Fecha(24, 2, 2024);
        fecha.imprimir();
        fecha.adelantar(5, 1, 0);
        fecha.imprimir();
        fecha.cambiarAño(2023);
        System.out.println(fecha.obtenerFechaFormatoExtendido());
    }
    } 
}
