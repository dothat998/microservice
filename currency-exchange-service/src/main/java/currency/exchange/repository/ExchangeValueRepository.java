package currency.exchange.repository;


import currency.exchange.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from,String to);
}
