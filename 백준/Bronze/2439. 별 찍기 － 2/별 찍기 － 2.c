#include<stdio.h>
int main()
{
    int a,b,c,n;
    scanf("%d",&n);
    for(a=1;a<=n;a++)
    {
        for(b=a;b<n;b++)
            printf(" ");
        for(c=1;c<=a;c++)
            printf("*");
        printf("\n");
        
    }
    return 0;
        
}