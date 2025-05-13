package Magazzino;

public class Missione {

	public Missione() {
		
	}

}

public void bubbleSort(int [] array) {
for(int i = 0; i < array.length; i++) {
boolean flag = false;
for(int j = 0; j < array.length-1; j++) {
//se l'elemento puntato da j è maggiore del successivo 
//i valori vengono scambiati tra loro
if(array[j]>array[j+1]) {
int k = array[j];
 array[j] = array[j+1];
 array[j+1] = k;
 flag=true; 
 //lo setto a true per indicare che é avvenuto uno scambio
}
}
if(!flag) break; 
//se 'flag=false' 
//nell'ultima interazione non ci sono più scambi:
//l'array è ordinato e il metodo può chiudersi
}
}
