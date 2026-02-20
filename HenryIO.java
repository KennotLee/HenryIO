import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.util.StringTokenizer;
import java.util.Optional;
import java.util.stream.Stream;

public class HenryIO {

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    // Constructor where client provides streams
    public HenryIO(InputStream in, OutputStream out) {
        br = new BufferedReader(new InputStreamReader(in));
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));
    }

    // Optional convenience constructor
    public HenryIO() {
        this(System.in, System.out);
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public void print(Object o) {
        out.print(o);
    }

    public void println(Object o) {
        out.println(o);
    }

    public void flush() {
        out.flush();
    }

    public void close() throws IOException {
        flush();
        br.close();
        out.close();
    }

    public Optional<Integer> tryNextInt() throws IOException {
        String token = next();
        if (token == null) {
            return Optional.empty();
        }
        return Optional.of(Integer.parseInt(token));
    }

    public Optional<Long> tryNextLong() throws IOException {
        String token = next();
        if (token == null) {
            return Optional.empty();
        }
        return Optional.of(Long.parseLong(token));
    }

    public Optional<Double> tryNextDouble() throws IOException {
        String token = next();
        if (token == null) {
            return Optional.empty();
        }
        return Optional.of(Double.parseDouble(token));
    }

    public Optional<String> tryNext() throws IOException {
        String token = next();
        if (token == null) {
            return Optional.empty();
        }
        return Optional.of(token);
    }
    
    public Optional<String> tryNextLine() throws IOException {
        String line = br.readLine();
        if (line == null) {
            return Optional.empty();
        }
        return Optional.of(line);
    }

    public Stream<String> lines() {
        return br.lines();
    }

    public Stream<String> tokens() {
        return Stream.generate(() -> {
            try {
                return next();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }).takeWhile(token -> token != null);
    }
}