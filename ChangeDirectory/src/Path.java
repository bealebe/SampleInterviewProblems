import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("Since15")
public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) throws IllegalArgumentException{

        newPath = newPath.replace(" ", "");
        if (!newPath.matches("[a-zA-Z/]*")){
            if((!newPath.contains("../") || newPath.contains("...")) && !newPath.equals("..")){
                throw new IllegalArgumentException("Invalid Directory Entered");
            }
        }

        if (isAbsolutePath(newPath)){
            path = normalizePath(newPath);
        }
        else{
            path = normalizePath(path + "/" + newPath);
        }

    }

    private String normalizePath(String pPath) {
        boolean isAbsolute = isAbsolutePath(pPath);

        List<String> parts = new ArrayList<String>();
        for(String part : pPath.split("/")){
            if(part.isEmpty() || part.equals(".")){
                continue;
            }
            if (part.equals("..")){
                if(parts.isEmpty()){
                    if(isAbsolute){
                        continue;
                    }
                }
                else{
                    if(!parts.get(parts.size() -1).equals("..")){
                        parts.remove(parts.size() -1);
                        continue;
                    }
                }
            }
            parts.add(part);
        }

        String rootDir = isAbsolute ? "/" : "";
        return rootDir + String.join("/", parts);
    }

    private boolean isAbsolutePath(String path) {
        return (path.charAt(0) == '/');
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(path.getPath() + " -> cd ");
                path.cd(input.nextLine());
                System.out.println(path.getPath());
            }
            catch (IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }
    }
}