public class Missione {
//Programma Java per ordinare un array di interi
//con il metodo BubbleSort

@SuppressWarnings("null")
public static void main(String[] args) {
	//stampo l'array prima dell'ordinamento
	System.out.println("Array prima dell'ordinamento: ");
	int[] array = null;
	for(int i=0; i<array.length; i++) {
		System.out.print(array[i] + " ");
	
	System.out.println();

	//chiamo il metodo bubbleSort passando l'array
	bubbleSort(array);
	}
}

public static void bubbleSort(int [] array) {
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
 //lo imposto come true per indicare che é avvenuto uno scambio
}
}
if(!flag) break; 
//se 'flag=false' significa che 
//nell'ultima interazione non ci sono più scambi:
//l'array è ordinato e il metodo può chiudersi
}
//stampo l'array dopo l'ordinamento
System.out.println("Array dopo l'ordinamento: ");
}
}
