package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.module.CurrentModule;
import seedu.address.model.module.PlannedModule;
import seedu.address.model.module.PreviousModule;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Github;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.user.User;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setPhone(person.getPhone());
        descriptor.setEmail(person.getEmail());
        descriptor.setAddress(person.getAddress());
        descriptor.setGithub(person.getGithub());
        descriptor.setTags(person.getTags());
        descriptor.setCurrModules(person.getCurrModules());
        descriptor.setPrevModules(person.getPrevModules());
        descriptor.setPlanModules(person.getPlanModules());
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code user}'s details
     */
    public EditPersonDescriptorBuilder(User user) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(user.getName());
        descriptor.setPhone(user.getPhone());
        descriptor.setEmail(user.getEmail());
        descriptor.setAddress(user.getAddress());
        descriptor.setGithub(user.getGithub());
        descriptor.setCurrModules(user.getCurrModules());
        descriptor.setPrevModules(user.getPrevModules());
        descriptor.setPlanModules(user.getPlanModules());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Sets the {@code Github} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withGithub(String github) {
        descriptor.setGithub(new Github(github));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    /**
     * Parses the {@code currModules} into a {@code Set<CurrentModule>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withCurrentModules(String... currentModules) {
        Set<CurrentModule> currentModuleSet = Stream.of(currentModules)
                .map(CurrentModule::new).collect(Collectors.toSet());
        System.out.println("withCurrentModules");
        descriptor.setCurrModules(currentModuleSet);
        return this;
    }

    /**
     * Parses the {@code prevModules} into a {@code Set<PreviousModule>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withPreviousModules(String... previousModules) {
        Set<PreviousModule> previousModuleSet = Stream.of(previousModules)
                .map(PreviousModule::new).collect(Collectors.toSet());
        descriptor.setPrevModules(previousModuleSet);
        return this;
    }

    /**
     * Parses the {@code planModules} into a {@code Set<PlannedModule>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withPlannedModules(String... plannedModules) {
        Set<PlannedModule> plannedModuleSet = Stream.of(plannedModules)
                .map(PlannedModule::new).collect(Collectors.toSet());
        descriptor.setPlanModules(plannedModuleSet);
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
