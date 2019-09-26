package com.example.eventbuscompare.EventBus2_4;

public final class SubscriberExceptionEvent {
    /** The {@link EventBus} instance to with the original event was posted to. */
    public final EventBus eventBus;

    /** The Throwable thrown by a subscriber. */
    public final Throwable throwable;

    /** The original event that could not be delivered to any subscriber. */
    public final Object causingEvent;

    /** The subscriber that threw the Throwable. */
    public final Object causingSubscriber;

    public SubscriberExceptionEvent(EventBus eventBus, Throwable throwable, Object causingEvent,
                                    Object causingSubscriber) {
        this.eventBus = eventBus;
        this.throwable = throwable;
        this.causingEvent = causingEvent;
        this.causingSubscriber = causingSubscriber;
    }

}
