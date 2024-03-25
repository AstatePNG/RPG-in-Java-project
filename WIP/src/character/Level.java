package character;

public class Level {
	
	private int xp;
	private int currentLevel;
	private int totalXp;
	private int xpToNextLevel;
	private static final int MAXLEVEL=255;
	private static final int MINLEVEL=1;
	
	public Level () {
		xp = 0;
		currentLevel = MINLEVEL;
		totalXp = 0;
		xpToNextLevel = 100;
	}
	
	public Level(int currentLevel) {
		if(!isLegalLevel(currentLevel)) {
			throw new IllegalArgumentException("Le niveau saisi n'a pas une valeur valide.");
		}
		else {
			this.currentLevel = currentLevel;
			xp = 0;
			totalXp = this.totalXpToNextLevel(currentLevel);
			this.refreshXpToNextLevel();
		}
	}
	
	public Level(int currentLevel, int xp) {
		if(!isLegalLevel(currentLevel)) {
			throw new IllegalArgumentException("Le niveau saisi n'a pas une valeur valide.");
		}
		else {
			this.currentLevel = currentLevel;
			totalXp = xp + this.totalXpToNextLevel(currentLevel);
			this.refreshXpToNextLevel();
			if(xp<0) {
				throw new IllegalArgumentException("La quantité d'experience ne peut pas être négative");
			}
			else {
				while(xp >= xpToNextLevel) {
					xp -= xpToNextLevel;
					if(!isLegalLevel(this.currentLevel+1)) {
						throw new IllegalArgumentException("La quantité d'experience entrée est trop importante");
					}
					else {
						currentLevel += 1;
					}
				}
				this.xp = xp;
			}
		}
	}
	
	private boolean isLegalLevel(int levelToTry) {
		return (levelToTry >= MINLEVEL && levelToTry <= MAXLEVEL);
	}
	
	private void refreshXpToNextLevel() {
		xpToNextLevel = 100 + 50*(currentLevel-1);
	}
	
	private int totalXpToNextLevel(int currentLevel) {
		int result=0;
		for(int i=0;i<currentLevel-1;i++) {
			result+=100+50*i;
		}
		return result;
	}
	
	public void addXp(int xpToAdd) {
		if(xpToAdd<0) {
			throw new IllegalArgumentException("La quantité d'experience ne peut pas être négative");
		}
		else {
			while(xpToAdd >= xpToNextLevel) {
				if(!isLegalLevel(this.currentLevel+1)) {
					xp = xpToNextLevel-1;
					xpToAdd=0;
				}
				else {
					xpToAdd -= xpToNextLevel;
					currentLevel += 1;
				}
			}
			xp += xpToAdd;
		}
	}

	public int getXp() {
		return xp;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public int getTotalXp() {
		return totalXp;
	}

	public int getXpToNextLevel() {
		return xpToNextLevel;
	}

	@Override
	public String toString() {
		return ("Niv " + currentLevel + " XP : " + xp + "/" + xpToNextLevel + " Total xp : " + totalXp);
	}
	
}
