
import java.io.File;
import java.util.ArrayList;

public class DeleteFiles {

    public static void main(String[] args) {
        String folder = args[0];

        ArrayList<String> folderList = new ArrayList<String>();

        for (int i = 1; i <= args.length - 1; i++) {
            folderList.add(args[i]);
        }

        SearchAndDelete(new File(folder), folderList);
    }

    private static void recursiveDelete(File file) {


        if(file.isDirectory()){

            //directory is empty, then delete it
            if(file.list().length==0){

                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());

            }else{

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    recursiveDelete(fileDelete);
                }

                //check the directory again, if empty then delete it
                if(file.list().length==0){
                    file.delete();
                    System.out.println("Directory is deleted : "
                            + file.getAbsolutePath());
                }
            }

        }else{
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }



    private static void SearchAndDelete(File file, ArrayList<String> folderList) {
        boolean deleted;
        if (!file.exists())
            return;

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (folderList.contains(f.getName()))
                    recursiveDelete(f);
                else
                    SearchAndDelete(f, folderList);
            }

        }
    }
}
