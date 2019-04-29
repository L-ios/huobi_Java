package com.huobi.client.examples;

import com.huobi.client.SubscriptionClient;
import com.huobi.client.SubscriptionOptions;
import com.huobi.client.model.Trade;

import java.util.List;

public class SubscribeTradeDetail {
    public static void main(String[] args) {
        SubscriptionOptions options = new SubscriptionOptions();
        options.setUri("wss://api.huobi.br.com");
        SubscriptionClient subscriptionClient = SubscriptionClient.create("", "",  options);
        System.out.println();
        subscriptionClient.subscribeTradeEvent("btcusdt", (candlestickEvent) -> {
            List<Trade> tradeList = candlestickEvent.getTradeList();
            for (Trade trade : tradeList) {
                System.out.println("Amount: " + trade.getAmount());
                System.out.println("TradeId: " + trade.getTradeId());
                System.out.println("Price: " + trade.getPrice());
                System.out.println("Direction: " + trade.getDirection());
                System.out.println("Timestamp: " + trade.getTimestamp());
            }
        });

    }
}
