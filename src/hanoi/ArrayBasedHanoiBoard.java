package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 * 
 * @author jcollard
 * 
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {
	private StackBasedHanoiPeg peg1 = new StackBasedHanoiPeg();
	private StackBasedHanoiPeg peg2 = new StackBasedHanoiPeg();
	private StackBasedHanoiPeg peg3 = new StackBasedHanoiPeg();
	private StackBasedHanoiPeg[] board = {peg1, peg2, peg3};
	
	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	public ArrayBasedHanoiBoard(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		for (int i = n; i > 0; i--) {
			board[0].addRing(new HanoiRing(i));
		}
	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if (!isLegalMove(move)) {
			throw new IllegalHanoiMoveException("Could not perform illegal move.");
		}
		board[move.getToPeg()].addRing(board[move.getFromPeg()].remove()); //add removed
	}

	@Override
	public boolean isSolved() {
		return (!board[0].hasRings() && !board[1].hasRings());
	}

	@Override
	public boolean isLegalMove(HanoiMove move) {
		if (move == null) {
			throw new NullPointerException();
		}
		else if (!board[move.getToPeg()].hasRings()) {
			return true;
		}
		else if (!board[move.getFromPeg()].hasRings()) {
			return false;
		}
		else if (board[move.getToPeg()].getTopRing().getSize() > board[move.getFromPeg()].getTopRing().getSize()) {
			return true;
		}
		return false;
	}
}
