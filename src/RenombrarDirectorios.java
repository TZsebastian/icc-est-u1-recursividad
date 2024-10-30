import java.io.File;

public class RenombrarDirectorios {
    
    public void RenombrarDirectorios(String path){
        // validemos que el path sea un directorio
        File directorio = new File(path);
        if(!directorio.exists() || !directorio.isDirectory()){
            System.out.println("La ruta path no es un directorio válido");
            return;
        }
        // Aca vamos a cambiarr los nombres
        // System.out.println("La ruta path válida");
        RenombrarDirectoriosInternos(directorio);
    }

    public void RenombrarDirectoriosInternos(File directorio) {
        // Listar todos los archivos y/o carpetas hijas
        File[] directoriosArchivosInternos = directorio.listFiles();
        if(directoriosArchivosInternos == null) {
            return;
        }
        for(File directorioArchivo : directoriosArchivosInternos) {
            if(directorioArchivo.isDirectory()) { // Si es carpeta cambio el nombre
                String nombreOriginal = directorioArchivo.getName();
                String nuevoNombre = "Nuevo-" + nombreOriginal;
                File nuevoDirectorio = new File(directorioArchivo.getParent(), nuevoNombre);
                if(directorioArchivo.renameTo(nuevoDirectorio)) {
                    RenombrarDirectoriosInternos(nuevoDirectorio);
                }
            }
        }
    }
}
