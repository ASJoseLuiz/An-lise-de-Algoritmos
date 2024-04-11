package atividade01.ProjetoTESTE;


public class Busca implements Busca_IF{

    private boolean buscaLinear_recursiva_aux(int[] v, int n, int k){
        if(n >= v.length){
            return false;
        }
        if(v[n] == k){
            return true;
        }
        else{
            return buscaLinear_recursiva_aux(v, n+1, k);
        }
    }

    private boolean buscaBinaria_recursiva_aux(int[] v, int i, int j, int k){
        if(j >= i){
            int m = i + (j - i)/2;
            if(v[m] == k){
                return true;
            }
            if(v[m] > k){
                return buscaBinaria_recursiva_aux(v, i, m - 1, k);
            }
            if(v[m] < k){
                return buscaBinaria_recursiva_aux(v, m + 1, j, k);
            }
        }
        return false;
    }

    @Override
    public int[] geraVetorNumericoOrdenado(int tamanho){
        int v[] = new int[tamanho];
        for(int i=0; i<tamanho; i++){
            v[i] = i + 1;
        }
        return v;
    }

    @Override
    public boolean buscaLinear_iterativa(int[] numeros, int k){
        for(int i=0; i<numeros.length; i++){
            if(numeros[i] == k){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscaLinear_recursiva(int[] numeros, int k){
        boolean v = buscaLinear_recursiva_aux(numeros, 0, k);
        if(v == true){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean buscaBinaria_iterativa(int[] numeros, int k){
        int i = 0; int j = numeros.length - 1;
        int m = 0;
        while (i <= j){
            m = i + (j - i)/2;
            if(numeros[m] == k){
                return true;
            }
            if(numeros[m] < k){
                i = m + 1;
            }
            if(numeros[m] > k){
                j = m - 1;
            }
        }
        return false;
    }

    @Override
    public boolean buscaBinaria_recursiva(int[] numeros, int k){
        boolean v = buscaBinaria_recursiva_aux(numeros, 0, numeros.length - 1, k);
        if(v == true){
            return true;
        }
        else{

            return false;
        }
    }

    @Override
    public boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k){
        int i = 0; int j = numeros.length - 1;
        while (i <= j){
            if(numeros[i] == k){
                return true;
            }
            if(numeros[j] == k){
                return true;
            }
            else{
                i++;
                j--;
            }
        }
        return false;
    }
}