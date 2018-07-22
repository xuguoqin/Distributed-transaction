package com.transaction.commons;

import com.transaction.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    private EventType eventType;
    private Object payload;
}
