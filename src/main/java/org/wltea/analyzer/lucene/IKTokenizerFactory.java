package org.wltea.analyzer.lucene;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import java.io.Reader;
import java.util.Map;

/**
 * TokenizerFactory 兼容solr 4.9
 */
public class IKTokenizerFactory extends TokenizerFactory  {

    private boolean useSmart;

    public IKTokenizerFactory(Map<String, String> args) {
        super(args);
        useSmart = getBoolean(args, "useSmart", false);
    }

    public Tokenizer create(AttributeFactory attributeFactory, Reader reader) {
        return new IKTokenizer(reader, useSmart);
    }
}
