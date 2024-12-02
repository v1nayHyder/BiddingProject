package com.binding.services;

import com.binding.daos.BindingDao;
import com.binding.daos.BuyerDao;
import com.binding.models.Binding;
import com.binding.models.BuyerBid;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class BindingService {
    private BindingDao bindingDao;
    private BuyerDao buyerDao;

    public BindingService() {
        this.bindingDao = new BindingDao();
        this.buyerDao=new BuyerDao();
    }

    public void createBinding(String name, String description, LocalDateTime createdAt,Double bidAmount)
    {
        Binding binding = new Binding(0, name.trim(), description, createdAt,bidAmount);
        bindingDao.addBinding(binding);
    }

    public List<Binding> getAllBindings()
    {
        return bindingDao.getAllBindings();
    }

    public BuyerBid createBuyerBid(String name,String product,Double bidAmount ) throws SQLException
    {
        boolean found= buyerDao.getBidByProductNameAndBidAmount(product.trim(),bidAmount);
        if(found) {
            BuyerBid buyerBid = new BuyerBid(0, name, product, bidAmount);
          return  buyerDao.createBuyerBid(buyerBid);
        }
  return null;
    }

    public List<BuyerBid> getAllBuyerBid()
    {
        return buyerDao.getAllBuyerBid();
    }
}
