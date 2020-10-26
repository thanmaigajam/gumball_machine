public class GumballMachine {

	public enum Coin {

		QUATER(25), NICKEL(5), DIME(10);

		private final int value;

		Coin(final int newValue) {
			value = newValue;
		}

		public int getValue() {
			return value;
		}

	}

	protected int gumballCount;
	protected int price;
	protected boolean acceptsAnyCoin;
	protected int amount;
	protected boolean isTurnable;

	public GumballMachine(int initialGumballCount, int price, boolean acceptsAnyCoin) {
		this.gumballCount = initialGumballCount;
		this.price = price;
		this.acceptsAnyCoin = acceptsAnyCoin;

	}

	public void insertCoins(Coin coin) {

		if (isTurnable) {
			System.out.println("Turn the crank before inserting another coin");
		} else {
			this.isTurnable = true;
			switch (coin) {
			case QUATER: {
				this.amount = amount + Coin.QUATER.getValue();
				break;
			}
			case DIME: {
				if (acceptsAnyCoin) {
					this.amount = amount + Coin.DIME.getValue();
				}
				break;
			}
			case NICKEL: {
				if (acceptsAnyCoin) {
					this.amount = amount + Coin.NICKEL.getValue();
				}
				break;
			}
			}
			this.isTurnable = true;
		}

	}


	public void turnCrank() {
		if (!this.isTurnable) {
			System.out.println("Insert coin to turn the crank.");
		} else if(gumballCount == 0){
			System.out.println("Machine out of gumballs.");
		} else {
			if (price <= amount) {
				gumballCount--;
				amount = 0;
				System.out.println("Here is your gumball.");
			} else {
				System.out.println("Not enough money.");
			}

			this.isTurnable = false;
		}
	}

	public static void main(String args[]) {
		GumballMachine gm25 = new GumballMachine(1, 25, false);
		gm25.insertCoins(Coin.QUATER);
		gm25.turnCrank();
		gm25.insertCoins(Coin.DIME);
		gm25.turnCrank();
		gm25.insertCoins(Coin.QUATER);
		gm25.turnCrank();
		gm25.turnCrank();

		System.out.println("--------");

		GumballMachine gm50 = new GumballMachine(10, 50, false);
		gm50.insertCoins(Coin.QUATER);
		gm50.turnCrank();
		gm50.insertCoins(Coin.DIME);
		gm50.insertCoins(Coin.DIME);
		gm50.insertCoins(Coin.NICKEL);
		gm50.turnCrank();
		gm50.insertCoins(Coin.QUATER);
		gm50.turnCrank();
		gm50.insertCoins(Coin.QUATER);
		gm50.turnCrank();
		gm50.insertCoins(Coin.QUATER);
		gm50.turnCrank();

		System.out.println("--------");

		GumballMachine gm50any = new GumballMachine(10, 50, true);
		gm50any.insertCoins(Coin.QUATER);
		gm50any.turnCrank();
		gm50any.insertCoins(Coin.DIME);
		gm50any.insertCoins(Coin.DIME);
		gm50any.insertCoins(Coin.DIME);
		gm50any.turnCrank();
		gm50any.insertCoins(Coin.DIME);
		gm50any.insertCoins(Coin.DIME);
		gm50any.insertCoins(Coin.NICKEL);
		gm50any.turnCrank();
		gm50any.insertCoins(Coin.DIME);
		gm50any.insertCoins(Coin.DIME);
		gm50any.insertCoins(Coin.NICKEL);
		gm50any.insertCoins(Coin.QUATER);
		gm50any.turnCrank();
	}
}
