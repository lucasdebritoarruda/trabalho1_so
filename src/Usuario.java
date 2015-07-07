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
			try {
				CaixaPostal.getInstance().getM().acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
