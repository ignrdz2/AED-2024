package com.example;

import java.util.Arrays;

public class TClasificador {
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;

	/**
	 * Punto de entrada al clasificador
	 * 
	 * @param metodoClasificacion
	 * @param orden
	 * @param tamanioVector
	 * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
	 */
	public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
		switch (metodoClasificacion) {
		case METODO_CLASIFICACION_INSERCION:
			return ordenarPorInsercion(datosParaClasificar);
		case METODO_CLASIFICACION_SHELL:
			return ordenarPorShell(datosParaClasificar);
		case METODO_CLASIFICACION_BURBUJA:
			return ordenarPorBurbuja(datosParaClasificar);
		default:
			System.err.println("Este codigo no deberia haberse ejecutado");
			break;
		}
		return datosParaClasificar;
	}

	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}


	/**
	 * @param datosParaClasificar
	 * @return
	 */
	private int[] ordenarPorShell(int[] datosParaClasificar) {
		int j, inc;
		int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

		for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
			inc = incrementos[posIncrementoActual];
			if (inc < (datosParaClasificar.length / 2)) {
				for (int i = inc; i < datosParaClasificar.length; i++) {
					j = i - inc;
					while (j >= 0) {
						if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
							intercambiar(datosParaClasificar, j, j + inc);
							j = j--;
						} 
					}
				}
			}
		}
		return datosParaClasificar;
	}


	/**
	 * @param datosParaClasificar
	 * @return
	 */
	protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
		if (datosParaClasificar != null) {
			for (int i = 1; i < datosParaClasificar.length; i++) {
				int j = i;
				while ((j > 0) && (datosParaClasificar[j] < datosParaClasificar[j - 1])) {
					intercambiar(datosParaClasificar, j, j - 1);
					j--;
				}
			}
			return datosParaClasificar;
		}
		return null;
	}

	private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
		datosParaClasificar = null;
		int n = datosParaClasificar.length - 1;
		for (int i = 0; i <= n; i++) {
			for (int j = n; j >= (i + 1); j--) {
				if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
					intercambiar(datosParaClasificar, j - 1, j);
				}
			}
		}
		return datosParaClasificar;
	}

	public boolean estaOrdenado(int[] datos) {
		for (int i = 0; i < datos.length - 1; i++) {
			if (datos[i] > datos[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {

		TClasificador clasif2 = new TClasificador();
    	int[] vectorDesordenado = new int[]{5, 3, 4, 1, 2};
		int[] resDesordenado = clasif2.clasificar(vectorDesordenado, METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resDesordenado.length; i++) {
			System.out.print(resDesordenado[i] + " ");
		}
		System.out.println("Esta ordenado: " + clasif2.estaOrdenado(resDesordenado));

		TClasificador clasif = new TClasificador();
		GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();


		// Insercion -> O(n^2) en el peor de los casos | Si los datos ya estan ordenados la complejidad es de O(n)
		// Shell -> O(n^2) pero en algun caso puede ser O(n log n)
		// Burbuja -> O(n^2) | Si los datos ya estan ordenados la complejidad es de O(n)

		// Insercion
		int[] vectorAleatorio = gdg.generarDatosAleatorios();
		int[] vectorAscendente = gdg.generarDatosAscendentes();
		int[] vectorDescendente = gdg.generarDatosDescendentes();

		int[] resAleatorio = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_INSERCION);
		int[] resAscendente = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_INSERCION);
		int[] resDescendente = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_INSERCION);

		System.out.println("Vector aleatorio ordenado: " + Arrays.toString(resAleatorio));
		System.out.println("Vector ascendente ordenado: " + Arrays.toString(resAscendente));
		System.out.println("Vector descendente ordenado: " + Arrays.toString(resDescendente));

		// // ShellSort
		// int[] resAleatorioShell = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_SHELL);
		// int[] resAscendenteShell = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_SHELL);
		// int[] resDescendenteShell = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_SHELL);
		// System.out.println("Vector aleatorio ordenado (Shell): " + Arrays.toString(resAleatorioShell));
		// System.out.println("Vector ascendente ordenado (Shell): " + Arrays.toString(resAscendenteShell));
		// System.out.println("Vector descendente ordenado (Shell): " + Arrays.toString(resDescendenteShell));
	
		// // Burbuja
		// int[] resAleatorioBurbuja = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_BURBUJA);
		// int[] resAscendenteBurbuja = clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_BURBUJA);
		// int[] resDescendenteBurbuja = clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_BURBUJA);
		// System.out.println("Vector aleatorio ordenado (Burbuja): " + Arrays.toString(resAleatorioBurbuja));
		// System.out.println("Vector ascendente ordenado (Burbuja): " + Arrays.toString(resAscendenteBurbuja));
		// System.out.println("Vector descendente ordenado (Burbuja): " + Arrays.toString(resDescendenteBurbuja));
	}
}
