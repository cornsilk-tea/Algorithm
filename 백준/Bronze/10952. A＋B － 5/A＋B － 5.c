#include<stdio.h>
int main()
{
    int A, B, N = 0;
    while(N < 200)
    {
        scanf("%d %d", &A, &B);
        if(A == 0 && B == 0)
            return 0;
        printf("%d\n", A + B);
        
    }
}