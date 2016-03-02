package hanoi;

import structures.LinkedStack;

/**
 * A {@link StackBasedHanoiPeg} is an implementation of {@link HanoiPeg}.
 * 
 * @author jcollard
 */
public class StackBasedHanoiPeg implements HanoiPeg {
	LinkedStack<Object> stack = new LinkedStack<Object>();
	HanoiRing top = null;

	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */
	public StackBasedHanoiPeg() {
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if (hasRings()) {
			HanoiRing tmpRing = (HanoiRing)stack.peek();
			if (ring == null || ring.getSize() >= tmpRing.getSize()) {
				throw new IllegalHanoiMoveException("Illegal move");
			}
		}
		top = ring;
		stack.push(ring);
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if (!hasRings()) {
			throw new IllegalHanoiMoveException("There are no rings on this peg");
		}
		top = (HanoiRing)stack.pop();
		return top;
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if (!hasRings()) {
			throw new IllegalHanoiMoveException("There are no rings on this peg");
		}
		top = (HanoiRing)stack.peek();
		return top;
	}

	@Override
	public boolean hasRings() {
		return stack.getSize() != 0;
	}
}
