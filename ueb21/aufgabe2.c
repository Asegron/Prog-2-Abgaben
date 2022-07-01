#include<stdio.h>

int main(void){ 
//Variablen
	float nettopreis;
	float mwSt;
	float bruttopreis;
	float skontobetrag;
	float rechnungsbetrag;
	float skonto = 0.02;
	char string [] = "Euro";
//einlesen Geldbetrag
printf("Bitte Nettopreis eingeben: ");
scanf("%f", &nettopreis);
//Mehrwertssteuer dazurechnen
mwSt = nettopreis/100 * 20;
//Bruttopreis berechnen
bruttopreis = nettopreis + mwSt;
//Skontobetrag berechnen
skontobetrag = bruttopreis * skonto;
//Rechnungsbetrag berechnen
rechnungsbetrag = bruttopreis - skontobetrag;

//Ausgabe auf Bildschirm, s-->Zeichenkette(Leerzeilen), %4.2f Eurobetrag
printf("Nettopreis %18s %4.2f\n", string, nettopreis);
printf("+ 20%% MwSt %18s %4.2f\n", string, mwSt);
printf("===================================== \n");
printf("Bruttopreis %17s %4.2f\n", string, bruttopreis);
printf("- 2%% Skonto %17s %4.2f\n", string, skontobetrag);
printf("===================================== \n");
printf("Rechnungsbetrag %13s %4.2f\n", string, rechnungsbetrag);
}
