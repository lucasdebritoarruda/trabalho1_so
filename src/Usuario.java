public class Usuario implements Runnable {

	int id, te;

	public Usuario(int id, int te) {
		super();
		this.id = id; // identificador do usu‡rio
		this.te = te; // tempo de escrita
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			escrevendo();
			if(CaixaPostal.getInstance().getM().availablePermits() != CaixaPostal.getInstance().pombo.N){
				try {
					CaixaPostal.getInstance().getM().acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				CaixaPostal.getInstance().getP().release();
			}
			
	}
}

	private void escrevendo() {
		long startTime = System.currentTimeMillis();

		while (this.te >= (System.currentTimeMillis() - startTime)) {
			System.out.println("Usuario " + this.id + " Escrevendo.");
		}
	}

}
