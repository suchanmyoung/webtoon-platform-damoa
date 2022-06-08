package com.damoawebtoon.parse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ParseStrategiesTest {

    @Test
    void 파싱전략들은_새로운객체로_생성이안되는지(){
        List<ParseStrategy> parseStrategies = ParseStrategies.parseStrategies;
        List<ParseStrategy> parseStrategies1 = ParseStrategies.parseStrategies;

        for (int i = 0; i < parseStrategies.size(); i++) {
            Assertions.assertThat(parseStrategies.get(i)).isEqualTo(parseStrategies1.get(i));
        }
    }
}