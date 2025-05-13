public class Locazione {
public String magazzino;
public String corridoio;
public int scaffale;
public int ripiano;
public String cella;
int maxPezzi;

public Locazione (String magazzino, String corridoio, int scaffale, int ripiano, String cella, int maxpezzi) {
	this.magazzino = magazzino;
	this.corridoio = corridoio;
	this.scaffale = scaffale;
	this.ripiano = ripiano;
	this.cella = cella;
	maxpezzi = 300;
	
}



}