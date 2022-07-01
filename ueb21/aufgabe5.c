#include <stdio.h>

void addieren(int);
void multiplizieren(int);

void addieren(int zahl) {
   zahl = zahl + zahl;
   printf("Addiert Zahl x zu Zahl x : %d\n", zahl);
}

void multiplizieren(int zahl) {
   zahl = zahl * zahl;
   printf("Zahl x mit Zahl x multipliziert : %d\n", zahl);
}

int main(void) {
   int eingabe, x;

   printf("Bitte geben Sie eine Zahl x  ein : ");
   scanf("%d",&x);
   printf("\t1.)Addieren\n\t2.)Multiplizieren\nIhre Wahl : "); //anzeige: 1.), 2.)
   scanf("%d",&eingabe);

   switch(eingabe) {
      case 1  : addieren(x);
                break;
      case 2  : multiplizieren(x);
                break;
      default : printf("Unbekannte Eingabe\n");
    }

	printf("Das Ergebnis ist immernoch %d\n",x);
   return 0;
}
