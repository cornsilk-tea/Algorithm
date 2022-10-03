#include<stdio.h>
int main()
{
    int H, M;
    scanf("%d %d", &H, &M);
    if(H < 1 && M <= 44)
        printf("23 %d", (60-(45-M)));
    else if(M <= 44)
        printf("%d %d", (H-1), (60-(45-M)));
	else
		printf("%d %d", H, (M - 45));
       
}