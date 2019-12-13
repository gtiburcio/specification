package br.com.estudos.specifications.repositories.spc;

import br.com.estudos.specifications.domain.Aluno;
import br.com.estudos.specifications.domain.filters.AlunoFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Objects;

public class AlunoSpecification implements Specification<Aluno> {

    private final AlunoFilter alunoFilter;

    public AlunoSpecification(AlunoFilter alunoFilter) {
        this.alunoFilter = alunoFilter;
    }

    public void add(Predicate predicate, Expression expression) {
        predicate.getExpressions().add(expression);
    }

    @Override
    public Predicate toPredicate(Root<Aluno> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if (Objects.nonNull(alunoFilter.getCpf()) && !alunoFilter.getCpf().isEmpty()) {
            add(predicate, criteriaBuilder.in(root.get("cpf")).value(alunoFilter.getCpf()));
        }

        if (Objects.nonNull(alunoFilter.getRg()) && !alunoFilter.getRg().isEmpty()) {
            add(predicate, criteriaBuilder.in(root.get("rg")).value(alunoFilter.getRg()));
        }

        if (Objects.nonNull(alunoFilter.getEmail()) && !alunoFilter.getEmail().isEmpty()) {
            add(predicate, criteriaBuilder.in(root.get("email")).value(alunoFilter.getEmail()));
        }

        if (Objects.nonNull(alunoFilter.getNome()) && !alunoFilter.getNome().isEmpty()) {
            add(predicate, criteriaBuilder.in(root.get("nome")).value(alunoFilter.getNome()));
        }

        if (Objects.nonNull(alunoFilter.getTelefone()) && !alunoFilter.getTelefone().isEmpty()) {
            add(predicate, criteriaBuilder.in(root.get("telefone")).value(alunoFilter.getTelefone()));
        }

        return predicate;
    }
}
