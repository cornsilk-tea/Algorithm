#include<stdio.h>
int main()
{
    int A, B, C, D, E;
	int result = 0;
		for(int n = 0; n < 5; n++)
		{
			scanf("%d", &A);
			if(A< 40)
				A = 40;
			result += A;
		}
	printf("%d", result/5);
}