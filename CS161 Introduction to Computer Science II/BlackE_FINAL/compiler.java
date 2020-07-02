import java.io.*;

public class compiler
{
  public static void main(String[] args)
  {
    String entry = new String("Project");

    try
    {
      PrintWriter writer = new PrintWriter("blabla2.bat", "UTF-8");
      writer.println("@echo off");
      writer.println("javac "entry".java");
      writer.println("java "entry"");
      writer.println("pause");
      writer.close();
      System.out.println("worked");
    }
    catch (IOException e)
    {
       System.out.println("didnt work");
    }

    editor = atom.workspace.getActivePaneItem();
    file = editor?.buffer.file;

    System.out.println(file);
  }
}
