#include<stdio.h>
#include<limits.h>


void ausgabe(void) {
    printf("__________\n");
}

int main(){

ausgabe();

// char
char c = 0;

do{
    c++;
}while(c > 0);

printf("Berechne min-Wert fuer char: %i\n", c);

c--;

printf("Berechne max-Wert fuer char:  %i\n", c);
printf("min-Vergleichswert aus der Libary fuer char: %i\n", CHAR_MIN);
printf("max-Vergleichswert aus der Libary fuer char: %i\n", CHAR_MAX);

ausgabe();

// unsignedChar
unsigned char unsignedChar = 0;

do{
    unsignedChar--;
}while(unsignedChar < 0);

printf("Berechne max-Wert fuer unsigned char:  %i\n", unsignedChar);
printf("Vergleichswert aus der Libary fuer unsigned char: %i\n", UCHAR_MAX);

ausgabe();

// short
short s = 0;

do{
    s++;
}while(s > 0);

printf("Berechne min-Wert fuer short: %i\n", s);

s--;

printf("Berechne max-Wert fuer short: %i\n", s);
printf("Vergleichswert aus Libary fuer short: %i\n", SHRT_MIN);
printf("Vergleichswert aus Libary fuer short: %i\n", SHRT_MAX);

ausgabe();

// unsignedShort
unsigned short unsignedShort = 0;

do{
    unsignedShort--;
}while(unsignedShort < 0);

printf("Berechne max-Wert fuer unsigned short:  %i\n", unsignedShort);
printf("Vergleichswert aus der Libary fuer unsigned short: %i\n", USHRT_MAX);

ausgabe();

// int
int i = 0;

do{
    i++;
}while(i > 0);


printf("Berechneter min-Wert fuer int: %i\n",i);

i--;

printf("Berechne max-Wert fuer int:  %i\n",i);
printf("min-Vergleichswert aus Libary fuer int: %i\n",INT_MIN);
printf("max-Vergleichswert aus Libary fuer int: %i\n",INT_MAX);

ausgabe();

// unsignedInt
unsigned int unsignedInt = 0;

while(unsignedInt+1 >0)
    unsignedInt++;

printf("Berechne max-Wert fuer unsigned int: %u\n", unsignedInt);
printf("max-Vergleichswert aus der Library fuer unsigned int: %u\n", UINT_MAX);

ausgabe();

return 0;
}
