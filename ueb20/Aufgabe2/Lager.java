import java.io.*;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;                        // NEU

    
/**
 *    Die Klasse:  Lager.java
 *    Realisiert eine allgemeine Lager-Klasse fuer
 *    Artikel.
 *
 * @version 2.01 Beta 04.01.2019
 * @author  Wolfgang Pauly
 *
 */

public class Lager
{
//------------------Konstanten----------------------------------
  
  public  static final int     STANDARD_DIMENSION = 5;
  public  static final String  STANDARD_LAGER_ORT = 
                               " (Ort noch nicht bestimmt) ";
  
  private static final String  DIMENSION_UNGUELTIG =
          "Ein zu konstruierendes Lager muss mindestens 1 Artikel aufnehmen koennen !";
  private static final String  LAGERORT_UNGUELTIG =
          "Der Lagerort-String muss initialisiert und nicht Leer sein !";

  private static final String  ARTIKEL_NICHT_IN_LAGER =
          "Verlangter Buchungs-Artikel nicht in Lager !!!!";
  private static final String  ARTIKEL_SCHON_IN_LAGER =
          "Anzulegender Artikel schon in Lager !!!!";
  
  private static final String  INDEX_UNGUELTIG =
          "Der Index ist zu gross oder zu klein !!!!";          
  
//------------------Attribute----------------------------------
  
  private  Map<Integer, Artikel> lager;                //NEU
  private  int                   initialCapacity;      //NEU
  private  String                lagerOrt;

//------------------Konstruktoren-------------------------------


  /**
   *    Der Konstruktor zur Standard-Initialisierung 
   *    des Lagers
   *        
   */
  public Lager ()
  {
   this( STANDARD_DIMENSION, STANDARD_LAGER_ORT );
  }



  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
   *        
   *    @param dimension  == Anzahl der maximal im Lager fuehrbaren Artikel
   */
  public Lager (int dimension)
  {
   this( dimension, STANDARD_LAGER_ORT );
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einem Lagerort und Standard-Artikel--Lagerplaetzen
   *        
   *    @param lagerOrt == Ort an dem das Lager existiert
   */
  public Lager (String lagerOrt)
  {
   this( STANDARD_DIMENSION, lagerOrt );
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
   *        
   *    @param dimension  == Anzahl der maximal im Lager fuehrbaren Artikel
   *    @param lagerOrt == Ort an dem das Lager existiert
   */
  public Lager (int dimension, String lagerOrt)
  {
   checkArgument( (dimension <= 0), DIMENSION_UNGUELTIG );
   checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)),
                  LAGERORT_UNGUELTIG 
	        );

   this.lagerOrt   = new String(lagerOrt); 
   lager           = new LinkedHashMap<Integer, Artikel>( dimension );  //NEU
   initialCapacity = dimension ;                                        //NEU
  }


//------------------ set-/get-lagerOrt---------------------------------

  /**
   *    gibt Lager-Attribut : lagerOrt zurueck
   *
   *    @return    lagerOrt
   */
  public String getLagerOrt ( )
  {
    return lagerOrt;
  }


  /**
   *    setzt Lager-Attribut :  lagerOrt
   *   
   *    @param lagerOrt     neuer Lager-Ort
   */
  public void setLagerOrt ( String lagerOrt )
  {
   checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)), 
                  LAGERORT_UNGUELTIG
		);

   this.lagerOrt = lagerOrt.trim();
  }

//------------------Artikel anlegen  ---------------------------------


  /**
   *    anlegen eines neuen Artikels und ins Lager einordnen
   *    
   *    @param einArtikel  der anzulegende Artikel
   */
  public void legeAnArtikel ( Artikel einArtikel )
  {
    checkArgument( lager.containsKey( einArtikel.getArtikelNr() ) ,
                   ARTIKEL_SCHON_IN_LAGER
		 );                                                   //NEU
    lager.put( einArtikel.getArtikelNr(), einArtikel );               //NEU
  }


//------------------Artikel entfernen ----------------------------------

  /**
   *    entfernt den Artikel anhand seiner Artikel-Nummer aus dem Lager
   *    
   *    @param   loeschArtikelNr Nummer des zu loeschenden Artikels
   *             
   */
  public void entfernen ( int loeschArtikelNr )
  {
    lager.remove( loeschArtikelNr );                                  //NEU
  }



//------------------ zugang buchen  --------------------------------

  /**
   *    bucht einen Zugang von Artikeln zu dem durch die Artikel-Nummer 
   *    identifizierten Artikel.
   *    
   *    @param   artikelNummer Artikel-Nummer, des zu buchenden Artikels
   *    @param zugang hinzukommende Artikel-Anzahl
   */
  public void bucheZugang ( int artikelNummer, int zugang )
  {
    checkArgument(  ! lager.containsKey( artikelNummer ), 
                    ARTIKEL_NICHT_IN_LAGER );                         //NEU

    lager.get( artikelNummer ).bucheZugang( zugang );                 //NEU;
  }


//------------------- abgang buchen  --------------------------------

  /**
   *    bucht einen Abgang von Artikeln von dem durch die Artikel-Nummer 
   *    identifizierten Artikel.
   *    
   *    @param   artikelNummer Artikel-Nummer, des zu buchenden Artikels
   *    @param abgang weggehende Artikel-Anzahl
   */
  public void bucheAbgang ( int artikelNummer, int abgang )
  {
    checkArgument(  ! lager.containsKey( artikelNummer ),
                    ARTIKEL_NICHT_IN_LAGER );                        //NEU

    lager.get( artikelNummer ).bucheAbgang( abgang );                 //NEU
  }




  /**
   *    preisaenderung - erhoeht, vermindert die Preise
   *                     aller Lagerartikel
   *
   *    @param  prozent - positive Prozentzahl == Preiserhoehung, negative = Preisverminderung 
   */
  public void aenderePreisAllerArtikel ( double prozent )
  {
    lager.values().stream().forEach((Artikel a) -> a.aenderePreis( prozent ));  //NEU
  }
 
//------------------- hilfs-Methoden --------------------------------


  /**
  *    getArtikelAnzahl - liefert die Anzahl Artikel im Lager
  *    
  *    @return Anzahl der Artikel im Lager
  */
  public int getArtikelAnzahl ()
            {
    return lager.size();
  }


//------------------ ausgebenBestandsListe --------------------------

  /**
   *    erzeugt einen String, der eine Bestandsliste repraesentiert
   *
   *    @return die String-Repraesentation der Lager-Bestandsliste
   */
  public String ausgebenBestandsListe ()
  {

    double zeilenWert, gesamtWert = 0;

    StringBuilder bestandsListe = new StringBuilder();
    Formatter formatierer = new Formatter( bestandsListe, Locale.GERMAN );

    formatierer.format( "\n-----B e s t a n d s L i s t e --------" +
                        "-----------------------------------------" +
                        "-------------------" +
                        "\n\nLagerort : %20s \n\n %6s   %-45s %10s %10s %10s" +
                        "\n--------------------------------------" +
                        "-----------------------------------------" +
                        "-------------------",
                        lagerOrt, "ArtNr", "Beschreibung", "Preis",
                        "Bestand", "Gesamt"
                       );
     Iterator<Artikel> iter = lager.values().iterator();               //NEU
     Artikel next;                                                     //NEU
     
     while ( iter.hasNext() )                                          //NEU
     {
        next = iter.next();                                           //NEU
    
        zeilenWert = next.getPreis() * next.getBestand();             //NEU
        gesamtWert += zeilenWert;                                     //NEU
        
        formatierer.format( "\n %6d   %45s %10.2f %10d %10.2f ",
                            next.getArtikelNr(),                      //NEU
                            next.getBeschreibung(),                   //NEU
                            next.getPreis(),                          //NEU
                            next.getBestand(),                        //NEU
                            zeilenWert
                          );
        // hier waere es evtl sinnvoll in den Klassen Artikel, Cd, Dvd und Buch 
        // eine Methode getBestandsZeile() zu programmieren, falls man auf
        // diese Klassen "quellcode-maessig" zugreifen kann.
      }

    formatierer.format( "\n--------------------------------------" +
                        "-----------------------------------------" +
                        "-------------------"
                       );
    formatierer.format( "\n Gesamtwert:                     " +
                        "                                   " +
                        "%20.2f", gesamtWert
                       );

   return bestandsListe.toString();
  }




//------------------ toString  --------------------------------------

  /**
   *    erzeugt einen String, der alle, fuer den Klassenbenutzer
   *    wichtigen, Lager-Merkmale enthaelt
   *   
   *    @return die String-Repraesentation des Lagers
   */
  public String toString ()
  {
    StringBuffer lagerString =                                                     //NEU
      new StringBuffer( String.format(                                             //NEU
                          "\n\nIm Lager >%s< sind von urspruenglich %d " +         //NEU
                          "Lagerplaetzen %d ",                                     //NEU
                          lagerOrt, initialCapacity, lager.size()                  //NEU
                      )              );                                            //NEU

    lagerString.append( "mit folgenden Artikeln belegt: \n");

    Iterator<Artikel> iter = lager.values().iterator();                            //NEU
    int i=0;                                                                       //NEU

    while ( iter.hasNext() )                                                       //NEU
    {
        i++;                                                                       //NEU
        lagerString.append( String.format( "\n    %3d\t-> %s", i, iter.next()) );  //NEU
    }

   return lagerString.toString();
  }


 //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
 // neue Funktionen ueb18
 //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


  //------------------ getSorted  --------------------------------------
  /**
   * Gibt die Artikel im Lager als sortiertes Array zurück. 
   * Das Sortierkriterium wird als Parameter an die Methode übergeben.
   * 
   * @param sortKrit - ein Prädikat-Objekt, welches das Sortierkriterium implementiert  
   * @return ein sortiertes Array der Artikel im Lager 
  public Artikel[] getSorted(BiPredicate<Artikel, Artikel> sortKrit)
    {
        return lager.values().stream().sorted( c ).collect( Collectors.toList() );   //NEU
    }
   */

   /**  Alternative Implementierung der getSorted Methode,
    *   unter Nutzung der sort Methode des List-Interfaces.
    *
    * @param  c   ein Comparator-Objekt zum Vergleich zweier Artikel
    * @return eine sortierte Liste der Artikel im Lager
    */
   public List<Artikel> getSorted( Comparator<Artikel> c )
   {
      return lager.values().stream().sorted( c ).collect( Collectors.toList() );   //NEU
   }

  
  //------------------ filter  --------------------------------------
  /**
   * Filtert die Artikel im Lager nach einem an die Methode übergebenen Filterkriterium. 
   * 
   * @param filterKrit - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @return eine Liste alle Artikel im Lager, die das Filterkriterium erfüllen. 
   */
  public List<Artikel> filter(Predicate<Artikel> filterKrit)
    {
        return lager.values().stream().filter( filterKrit ).collect( Collectors.toList() );   //NEU
    }
  
  
  //------------------ applyToArticles  --------------------------------------
  /**
   * wendet eine übergebene Operation auf alle Artikel im Lager an 
   * 
   * @param consum - ein Consumer der die auf die Artikel anzuwendende Operation implementiert
   */
  public void applyToArticles(Consumer<Artikel> consum)
    {
       lager.values().stream().forEach( consum ); //NEU
    }



  //------------------ applyToSomeArticles  --------------------------------------
  /**
   * wendet eine übergebene Operation auf alle Artikel, welche ein Filterkriterium erfüllen an
   *
   * @param f - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @param c - ein Consumer der die auf die Artikel anzuwendende Operation implementiert
   */
  public void applyToSomeArticles(Predicate<Artikel> f, Consumer<Artikel> c)
    {
      lager.values().stream().filter( f ).forEach( c );            //NEU
    }

  //------------------ getArticles  --------------------------------------
  /**
   * liefert eine sortierte Liste der Artikel, die ein gegebenes Filterkriterium erfüllen
   *
   * @param f - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @param c - ein Comparator-Objekt
   * @return eine sortierte Liste der gefilterten Artikel
   */
  public List<Artikel> getArticles(Predicate<Artikel> f, Comparator<Artikel> c)
    {
      return lager.values().stream().filter( f ).sorted( c ).collect( Collectors.toList() );  //NEU
    }

 //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 // neue Funktionen ueb18
 //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^




 /**
  *    wirft bei Fehlersituation eine IllegalArgumentException
  *    
  *    
  *    @param  fehler  -> true  == Fehlersituation
  *                    -> false == KEINE Fehlersituation
  *    @param  meldung -> Fehlermeldungstext zur Fehlersituation
  */
  private void   checkArgument( boolean fehler, String meldung )
  {
   if ( fehler )
     {
      throw new RuntimeException( meldung );
     }
  }

}

