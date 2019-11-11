package com.frankie.demo.optional;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * @author: Yao Frankie
 * @date: 2019/11/10 09:30
 */
@Setter
@Getter
public class Computer {
    public Optional<SoundCard> soundCard;
}
