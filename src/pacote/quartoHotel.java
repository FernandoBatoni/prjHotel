package pacote;

public class quartoHotel {
        private int numQuarto;
        private double valorDiaria;
        private int numRG;
        private boolean situacao;
        private double totalFaturado;
    
        public quartoHotel(int numQuarto, double valorDiaria) {
            this.numQuarto = numQuarto;
            this.valorDiaria = valorDiaria;
            this.situacao = false;
        }
        
        public void reservar(int numRG) {
            this.situacao = true;
        }

        public double liberar(int quantidadeDias) {
            double valorBruto = this.valorDiaria * quantidadeDias;
            this.totalFaturado += valorBruto;
            this.situacao = false;
            this.numRG = 0;         
            return totalFaturado;
        }
        
        public double getTotalFaturado() {
            return totalFaturado;
        }

        public boolean getSituacao(){
            return situacao;
        }

        public int getNumQuarto() {
            return numQuarto;
        }
    
        public double getValorDiaria() {
            return valorDiaria;
        }
    
             
        public void setNumRG(int numRG) {
             this.numRG = numRG;
        }
    
        public int getNumRG() {
            return numRG;
        }     
}

