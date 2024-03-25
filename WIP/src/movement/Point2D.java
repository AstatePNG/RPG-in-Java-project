package movement;

public class Point2D {
	
	private int x;
	private int y;
	
	public Point2D() {
		x=0;
		y=0;
	}
	
	public Point2D(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void moveSelf(int newX, int newY) {
		this.x=newX;
		this.y=newY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return ("(" + x + ";" + y + ")");
	}
	
	@Override
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		else {
			if (other != null) {
				if (other instanceof Point2D) {
					return (this.x == ((Point2D) other).getX() && this.y == ((Point2D) other).getY());
				}
			}
		}
		return false;
	}
	
}
