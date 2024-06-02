class TextEditor {
    Stack<Character> left = new Stack<>();
Stack<Character> right = new Stack<>();

public void addText(String text) {
	for (int i = 0; i < text.length(); i++) {
		left.push(text.charAt(i));
	}
}

public int deleteText(int k) {
	int cnt = 0;
	while (!left.isEmpty() && k-- > 0) {
		left.pop();
		cnt++;
	}
	return cnt;
}

public String cursorLeft(int k) {
	while (!left.isEmpty() && k-- > 0) {
		right.push(left.pop());
	}
	return getLeftString();
}

public String cursorRight(int k) {
	while (!right.isEmpty() && k-- > 0) {
		left.push(right.pop());
	}
	return getLeftString();
}

String getLeftString() {
	int cnt = 10;
	StringBuilder sb = new StringBuilder();
	while (!left.isEmpty() && cnt-- > 0) {
		sb.append(left.pop());
	}

	for (int i = sb.length() - 1; i >= 0; i--) {
		left.push(sb.charAt(i));
	}
	return sb.reverse().toString();
  }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */