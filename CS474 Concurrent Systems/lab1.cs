using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void sequential(int[] arr, int size)
        {
            int largest = 0;
            Stopwatch watch = new Stopwatch();

            watch.Start();
            for (int e = 0; e < size; e++)
            {
                if (largest < arr[e])
                {
                    largest = arr[e];
                }
            }
            watch.Stop();

            Console.WriteLine("sequential:\tlargest: " + largest + "\tduration: {0}", watch.ElapsedMilliseconds);
        }

        static void parallel(int[] arr, int size)
        {
            int largest = 0;
            Stopwatch watch = new Stopwatch();

            watch.Start();
            Parallel.For(0, size, i =>
            {
                if (largest < arr[i])
                {
                    largest = arr[i];
                }
            });
            watch.Stop();

            Console.WriteLine("parallel:\tlargest: " + largest + "\tduration: {0}", watch.ElapsedMilliseconds);
        }

        static void Main(string[] args)
        {
            const int SIZE = 20;
            int[] array = new int[SIZE];
            Random rnd = new Random();

            for (int i = 0; i < SIZE; i++)
            {
                array[i] = rnd.Next(1, SIZE);
                //Console.WriteLine(array[i]);
            }

            sequential(array, SIZE);
            parallel(array, SIZE);

            Console.WriteLine("\nPress any key to exit.");
            Console.ReadKey();
        }
    }
}
