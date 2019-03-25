package storage.initor.datasourcereader;

public interface XmlParser<T> {
    T parseFile(String file) throws Exception;
}
