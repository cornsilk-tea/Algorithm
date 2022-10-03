#include<stdio.h>
int main()
{
    int R, A, B, C;
    scanf("%d", &R);
    for(C = 0; C < R; C++)
    {
        scanf("%d %d\n", &A, &B);
        printf("%d\n", A + B);
    }
}