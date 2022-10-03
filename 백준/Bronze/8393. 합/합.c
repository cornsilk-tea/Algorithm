#include<stdio.h>
int main()
{
    int N, C, R;
    scanf("%d", &N);
		R = 0;
		N = N+1;
    for(C = 1; C < N; C++)
    {
        R = R + C;
    }
	printf("%d", R);
}