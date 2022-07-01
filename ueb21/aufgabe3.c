#include<stdio.h>

int main(){
//Variablen
long n;
long n1 = 0;
long n2 = 1;
long fibFolge;

//Zahl n einlesen
printf("Bitte Zahl eingeben: ");
scanf("%ld", &n); //%d-->int wird eingelesen, &n--> n mitnehmen
printf("Fibonacci-Folge: ");

for(long i = 1; i <= n; i++){
	printf("%ld ", n1);
	fibFolge = n1 + n2;
	n1 = n2;
	n2 = fibFolge;
	} printf("\n");
	return 0;
} 
