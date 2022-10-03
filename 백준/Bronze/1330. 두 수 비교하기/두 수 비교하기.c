#include<stdio.h>
int main()
{
    int A, B;
    scanf("%d %d", &A, &B);
    if(A > B)
        puts(">\n");
    else if(A < B)
        puts("<\n");
    else if(A == B)
        puts("==\n");
}