/*Case #1: 1 + 1 = 2*/
#include<stdio.h>
int main()
{
    int A, B, C, N, R;
    scanf("%d", &N);
    for(R = 0; R < N; R++)
    {
        scanf("%d %d", &A, &B);
        printf("Case #%d: %d + %d = %d\n", R+1, A, B, A+B);
    }
}