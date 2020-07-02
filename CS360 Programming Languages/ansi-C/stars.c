#include <stdio.h>
int fib(int);

int main(int argc, char *argv[])
{
  int input,num;
  printf("Give me a number\n");
  scanf("%d",&input);
  num=fib(input);

  for(int e=0;e<num;e++)
  {
    /*int i=0,u=0;
    while(i<=e)
    {
      while(u<=(num-e+2))
      {
        printf(" ");
        u++;
      }
      printf(" *");
      i++;
    }*/
    for(int i=0;i<=e;i++)
    {
      for(int u=0;u<=(num-e);u++)
      {
        printf(" ");
      }
      printf(" *");
    }
    printf("\n");
  }
  printf("The Fibonacci number is %d\n",fib(input));
}

int fib(int n)
{
  if(n<=1)
    return 1;
  else
    return (fib(n-1)+fib(n-2));
}
