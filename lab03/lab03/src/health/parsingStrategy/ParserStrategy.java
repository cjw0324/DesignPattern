package health.parsingStrategy;

public interface ParserStrategy<T> {
    T parse(String line);
}
