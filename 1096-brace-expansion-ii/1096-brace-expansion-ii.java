class Solution {

    public List<String> braceExpansionII(String expression) {
        Deque<Character> op = new ArrayDeque<>();
        List<Set<String>> st = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ',') {
                while (!op.isEmpty() && op.peek() == '*')
                    calc(op, st);
                op.push('+');

            } else if (c == '{') {
                if (i > 0 && (expression.charAt(i - 1) == '}' ||
                              Character.isLetter(expression.charAt(i - 1))))
                    op.push('*');

                op.push('{');

            } else if (c == '}') {
                while (op.peek() != '{')
                    calc(op, st);
                op.pop();

            } else {
                if (i > 0 && (expression.charAt(i - 1) == '}' ||
                              Character.isLetter(expression.charAt(i - 1))))
                    op.push('*');

                Set<String> set = new TreeSet<>();
                set.add(String.valueOf(c));
                st.add(set);
            }
        }

        while (!op.isEmpty())
            calc(op, st);

        return new ArrayList<>(st.get(st.size() - 1));
    }

    void calc(Deque<Character> op, List<Set<String>> st) {
        int l = st.size() - 2;
        int r = st.size() - 1;

        if (op.peek() == '+') {
            st.get(l).addAll(st.get(r));
        } else {
            Set<String> set = new TreeSet<>();

            for (String a : st.get(l))
                for (String b : st.get(r))
                    set.add(a + b);

            st.set(l, set);
        }

        op.pop();
        st.remove(st.size() - 1);
    }
}