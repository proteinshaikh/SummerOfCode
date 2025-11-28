package Algorithms;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.Collection;

public class AhoCorasickAlgorithm {

    public static void main(String[] args) {

        Trie trie = Trie.builder()
                .addKeyword("he")
                .addKeyword("she")
                .addKeyword("his")
                .addKeyword("hers")
                .build();

        String text = "ahishers";

        Collection<Emit> results = trie.parseText(text);

        for (Emit e : results) {
            System.out.println(
                    "Found \"" + e.getKeyword() +
                            "\" at [" + e.getStart() +
                            " - " + e.getEnd() + "]"
            );
        }
    }
}
