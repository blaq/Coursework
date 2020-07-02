using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace HW3
{
    public class Program
    {
        private static void PrintUsage()
        {
            Console.WriteLine("Usage is:\n" +
                "\tHW3.exe C inputfile outputfile\n\n" +
                "Where:" +
                "  C is the column number to fit to\n" +
                "  inputfile is the input text file \n" +
                "  outputfile is the new output file base name containing the wrapped text.\n" +
                "e.g. HW3.exe 72 myfile.txt myfile_wrapped.txt");
        }

        public static void Main(string[] args)
        {
            int C = 72;
            string inputFilename;
            string outputFilename = "output.txt";

            //argument catcher
            if (args.Length != 3)
            {
                PrintUsage();
                Environment.Exit(1);
            }
            try 
            {
                C = int.Parse(args[0]);
                inputFilename = args[1];    //will look in */bin/debug
                outputFilename = args[2];   //will look in */bin/debug
                
                //Scanner
                string text = File.ReadAllText(inputFilename);
                text = Regex.Replace(text, @"\t|\n|\r", " ");
                text = Regex.Replace(text, @"\s+", " ");
                string[] wordArray = text.Split(' ');

                IQueueInterface<string> words = new LinkedQueue<string>();

                for (int i = 0; i < wordArray.Length; i++)
                {
                    _ = words.Push(wordArray[i]);
                }

                int spacesRemaining = WrapSimply(words, C, outputFilename);
                Console.WriteLine($"Total spaces remaining (Greedy): {spacesRemaining}");
            }
            catch (FileNotFoundException)
            { 
                Console.WriteLine("Could not find the input file.");
                Environment.Exit(1);
            }
            catch (Exception)
            {
                Console.WriteLine("Something is wrong with the input.");
                PrintUsage();
                Environment.Exit(1);
            }
        }

        private static int WrapSimply(IQueueInterface<string> words, int columnLength, string outputFilename)
        {
            int spacesRemaining = 0;

            try
            {
                using (StreamWriter output = new StreamWriter(outputFilename))
                {
                    int col = 1;
                    while (!words.GetisNullOrEmpty)
                    {
                        string str = words.Peek();
                        int len = str.Length;

                        if (col == 1)
                        {
                            output.Write(str);
                            col += len;
                            _ = words.Pop();
                        }
                        else if ((col + len) >= columnLength)
                        {
                            output.Write(Environment.NewLine);
                            spacesRemaining += (columnLength - col) + 1;
                            col = 1;
                        }
                        else
                        {
                            output.Write(" ");
                            output.Write(str);
                            col += len + 1;
                            _ = words.Pop();
                        }
                    }

                    output.Write(Environment.NewLine);
                    output.Close();
                }
            }
            catch (FileNotFoundException)
            {
                Console.WriteLine($"Cannot create or open {outputFilename} for writing.  Using standard output instead.");
            }

            return spacesRemaining;
        }
    }
}
